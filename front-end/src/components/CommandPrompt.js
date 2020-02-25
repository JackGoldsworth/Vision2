import React from 'react'

export const CommandPrompt = () => {
    return (
        <div className="container" onLoad={onLoad}>
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

const onLoad = () => {
    if (window.location.hash) {
        fetch("http://localhost:8080/", {
            method: "POST",
            body: window.location.hash.toString()
        });
    }
}

const sendSearch = () => {
    let input = document.getElementById("search").value;
    fetch("http://localhost:8080/v1/command", {
        method: "POST",
        body: input
    });
}