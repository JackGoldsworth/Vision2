import React from 'react';
import {NavBar} from './components/NavBar'
import {CurrentTask} from "./components/CurrentTask";
import {CommandPrompt} from "./components/CommandPrompt";
import {TaskResponse} from "./components/TaskResponse";
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";

let stompClient = null;

export class App extends React.Component {

    render() {
        return (
            <div>
                <NavBar/>
                <CurrentTask/>
                <CommandPrompt/>
                <TaskResponse/>
            </div>
        )
    }

    connect(bind) {
        let socket = new SockJS('/info');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected');
            stompClient.subscribe('/results', function (messageOutput) {
                let body = JSON.parse(messageOutput.body).body
                let winner = null;
                if (body.winner != null) {
                    winner = body.winner.username
                    axios.post("http://localhost:8080/parties/disband",
                        getUsername(),
                        {headers: {"Content-Type": "application/json"}}
                    )
                }

                bind.setState({
                    isCzar: getUsername() === body.czar,
                    czar: body.czar,
                    blackCard: body.blackCard.cardMessage,
                    users: body.users,
                    playedCards: body.playedCards,
                    winner: winner
                });
            });
            bind.sendMessage(getUsername())
        });
    }

    sendMessage(message) {
        stompClient.send("/info", {}, message);
    }

    componentWillUnmount() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    }
}