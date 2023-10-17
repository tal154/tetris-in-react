//import react from 'react';
import { CanvasHTMLAttributes } from 'react';
//Components
import Stage from './Stage';
import Display from './Display';
//import StartButton from './StartButton';

const Landing = () => {


    return (
        <>
            <h2>Tetris</h2>
            <div>
                <h4 id="status">Play</h4>
                <button id="instructions">Instructions</button>
                {/*<!--Button for instructions -->*/}
                <div id="myModal" class="modal">
                    <div class="modal-content">
                        <span class="close">&times;</span>
                        <Stage />
                        <aside>
                            <button id="instructions">Instructions</button>
                            <div>
                                <Display text="Left Arrow: moves the block left" />
                                <Display text="Right Arrow: moves the block right" />
                                <Display text="Down Arrow: Accelerates the block's fall" />
                                <Display text="Up Arrow: Rotate the block" />
                                <Display text="Score as many points as possible by clearing horizontal lines of Blocks." />
                                <Display text="You must rotate, move, and drop the falling Tetriminos inside the playing field." />
                                <Display text="Lines are cleared when they are filled with Blocks and have no empty spaces." />
                            </div>
                        </aside>
                    </div>
                </div>
                <div id="button-container">
                    <button id="start">Start</button>
                    <h3>Score:<span id="score">0</span></h3>
                    <button id="reset">Reset</button>
                </div>
                <canvas id="tetris" width="240" height="400" />
                <script src="Tetris.js"></script>
            </div>
        </>
    );
};

export default Landing;