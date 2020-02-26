import React from 'react';
import {NavBar} from './components/NavBar'
import {CurrentTask} from "./components/CurrentTask";
import {CommandPrompt} from "./components/CommandPrompt";

function App() {
    return (
        <div>
            <NavBar/>
            <CurrentTask/>
            <CommandPrompt/>
        </div>
    )
}

export default App;

