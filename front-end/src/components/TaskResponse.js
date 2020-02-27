import React from 'react'
import ReactDOM from 'react-dom';

const axios = require('axios').default;

export class TaskResponse extends React.Component {

    render() {
        return (
            <div id="response" style={{marginTop: 5 + 'vh'}}>

            </div>
        )
    }

    componentDidMount() {
        getTaskResponse()
    }
}

const getTaskResponse = () => {
    axios.get("http://localhost:8080/v1/command/response",
        {headers: {"Content-Type": "plain/text"}})
        .then((response) => {
            let paragraphs = []
            if(response.status === 200) {
                let splitResponse = response.data.toString().split(" , ")
                for (let i = 0; i < splitResponse.length - 1; i++) {
                    paragraphs.push(<p style={{textAlign: "center"}}>{splitResponse[i]}</p>)
                }
            }
            ReactDOM.render(
                <div class="content">
                    {paragraphs}
                </div>,
                document.getElementById('response')
            );
        });
}