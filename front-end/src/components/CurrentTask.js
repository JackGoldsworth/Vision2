import React from "react";
const Client = require('node-rest-client').Client;
let client = new Client()

export const CurrentTask = () => {
    return (
        <div>

        </div>
    )
}

const getSpotifyImage = () => {
    client.get("")
}