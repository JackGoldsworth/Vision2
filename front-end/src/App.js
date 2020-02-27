import React from 'react';
import {NavBar} from './components/NavBar'
import {CurrentTask} from "./components/CurrentTask";
import {CommandPrompt} from "./components/CommandPrompt";
import {TaskResponse} from "./components/TaskResponse";

function App() {
    return (
        <div>
            <NavBar/>
            <CurrentTask/>
            <CommandPrompt/>
            <TaskResponse/>
        </div>
    )
}

export default App;

