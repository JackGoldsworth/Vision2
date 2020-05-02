import React from 'react'

const axios = require('axios').default;

export class CommandPrompt extends React.Component {

    render() {
        return (
            <div className="container">
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
}

const sendSearch = () => {
    let input = document.getElementById("search").value;
    axios.post("http://localhost:8080/v1/command",
        input.toString(),
        {headers: {"Content-Type": "text/plain"}}
    ).then(() => {
        //window.location.reload();
    });
}