import React from 'react';
import {NavBar} from './components/NavBar'
import {CurrentTask} from "./components/CurrentTask";
import {CommandPrompt} from "./components/CommandPrompt";
import {TaskResponse} from "./components/TaskResponse";
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";

let stompClient = null;

export class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            taskName: "",
            taskInfo: []
        }
        this.connect(this)
    }

    render() {
        return (
            <div>
                <NavBar/>
                <CurrentTask taskInfo={this.state.taskInfo}/>
                <CommandPrompt/>
                <TaskResponse taskInfo={this.state.taskInfo}/>
            </div>
        )
    }

    connect(bind) {
        let socket = new SockJS('/info');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function () {
            console.log('Connected');
            stompClient.subscribe('/results', function (messageOutput) {
                let body = JSON.parse(messageOutput.body).body
                bind.setState({
                    taskName: body.taskName,
                    taskInfo: body.taskInfo
                });
            });
            bind.sendMessage()
        });
    }

    sendMessage() {
        stompClient.send("/info", {});
    }

    componentWillUnmount() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    }
}