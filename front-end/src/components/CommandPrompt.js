import React from 'react'
import ReactDOM from 'react-dom';

const axios = require('axios').default;

export class CommandPrompt extends React.Component {

    render() {
        return (
            <div className="container">
                <div id="current-track"></div>
                <div>
                    <h1 style={{textAlign: 'center', fontSize: 5 + 'vh', marginTop: 5 + 'vh'}}>Current Task</h1>
                </div>
                <div className="field has-addons" style={{marginTop: 7 + 'vh'}}>
                    <div className="control is-expanded">
                        <input id="search" className="input " type="text" placeholder="Enter a command"/>
                    </div>
                    <div className="control">
                        <a className="button is-info" onClick={sendSearch}>
                            Search
                        </a>
                    </div>
                </div>
            </div>
        )
    }

    componentDidMount() {
        getSpotifyImage()
    }
}

const sendSearch = () => {
    let input = document.getElementById("search").value;
    axios.post("http://localhost:8080/v1/command",
        input.toString(),
        {headers: {"Content-Type": "text/plain"}}
    ).then(() => {
        window.location.reload();
    });
}

const getSpotifyImage = () => {
    axios.get("http://localhost:8080/v1/spotify/track",
        {headers: {"Content-Type": "application/json"}})
        .then((response) => {
            console.log(response.data)
            ReactDOM.render(
                <div>
                    <img src={response.data["imageUrl"]} alt={'Spotify Track'}
                         style={{display: "block", margin: "0 auto"}}/>
                    <p style={{
                        textAlign: 'center',
                        fontSize: 3 + 'vh'
                    }}>{response.data["name"]} by {response.data["artist"]}</p>
                </div>,
                document.getElementById('current-track')
            );
        });
}