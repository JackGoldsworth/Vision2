import React from 'react'

const axios = require('axios').default;

export class NavBar extends React.Component {

    render() {
        return (
            <nav className="navbar " role="navigation" aria-label="main navigation">
                <div id="visionNavbar" className="navbar-menu">
                    <div className="navbar-start">
                        <a className="navbar-item" href="/">
                            Home
                        </a>

                        <a className="navbar-item">
                            Settings
                        </a>
                    </div>

                <div className="navbar-end">
                    <div className="navbar-item">
                        <div className="buttons">
                            <a className="button is-success" onClick={clickLogin}>
                                <strong>Login to Spotify</strong>
                            </a>
                        </div>
                    </div>
                </div>
                </div>
            </nav>
        );
    }

    componentDidMount() {
        onLoad()
    }
}

const onLoad = () => {
    if (window.location.hash) {
        axios.post("http://localhost:8080/",
            window.location.hash.toString(),
            {headers: {"Content-Type": "text/plain"}}
        );
        window.location.replace("http://localhost:8080")
    }
}

const clickLogin = () => {
    let scopes = 'user-read-private user-read-email';
    axios.get("http://localhost:8080/v1/auth/credentials").then((response) => {
        window.location.replace('https://accounts.spotify.com/authorize' +
            '?response_type=token' +
            '&client_id=' + response.data["client_id"] +
            (scopes ? '&scope=' + encodeURIComponent(scopes) : '') +
            '&redirect_uri=' + encodeURIComponent(response.data["redirect_uri"]));
    })
}