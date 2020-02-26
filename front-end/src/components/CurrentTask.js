import React from 'react'
import ReactDOM from 'react-dom';

const axios = require('axios').default;

export class CurrentTask extends React.Component {

    render() {
        return (
            <div id="current-track" style={{marginTop: 5 + 'vh'}}>

            </div>
        )
    }

    componentDidMount() {
        getSpotifyImage()
    }
}

const getSpotifyImage = () => {
    axios.get("http://localhost:8080/v1/spotify/info",
        {headers: {"Content-Type": "application/json"}})
        .then((response) => {
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