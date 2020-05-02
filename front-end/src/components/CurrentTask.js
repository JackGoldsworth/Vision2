import React from 'react'

export class CurrentTask extends React.Component {

    render() {
        if (this.props.taskInfo.length !== 0) {
            return (
                <div id="current-track" style={{marginTop: 5 + 'vh'}}>
                    <div>
                        <img src={this.props.taskInfo["image"]} alt={'Spotify Track'}
                             style={{display: "block", margin: "0 auto"}}/>
                        <p style={{
                            textAlign: 'center',
                            fontSize: 3 + 'vh'
                        }}>{this.props.taskInfo["name"]} by {this.props.taskInfo["artist"]}</p>
                    </div>
                </div>
            )
        }
        return (
            <div id="current-track" style={{marginTop: 5 + 'vh'}}>
            </div>
        )
    }
}