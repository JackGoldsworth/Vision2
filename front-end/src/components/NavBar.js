import React from 'react'

export const NavBar = () => {
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
    )
}

const clickLogin = () => {
    let scopes = 'user-read-private user-read-email';
    fetch('http://localhost:8080/v1/auth/credentials').then((response) => {
        return response.json();
    }).then((myJson) => {
        let json = JSON.parse(JSON.stringify(myJson));
        window.location.replace('https://accounts.spotify.com/authorize' +
            '?response_type=token' +
            '&client_id=' + json["client_id"] +
            (scopes ? '&scope=' + encodeURIComponent(scopes) : '') +
            '&redirect_uri=' + encodeURIComponent(json["redirect_uri"]));
    });
}