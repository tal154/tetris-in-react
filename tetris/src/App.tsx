import React, { useState, useRef } from 'react';
import { createStage, isColliding } from './gameHelpers';

// Components
import Stage from './components/Stage/Stage';
import Display from './components/Display/Display';
import StartButton from './components/StartButton/StartButton';

// Custom hooks
import { useInterval } from './hooks/useInterval';
import { usePlayer } from './hooks/usePlayer';
import { useStage } from './hooks/useStage';
import { useGameStatus } from './hooks/useGameStatus';

import { DROPSPEED } from './setup';

// Styles
import { StyledTetrisWrapper, StyledTetris } from './App.styles';

const App: React.FC = () => {
  const [dropTime, setDropTime] = useState<null | number>(null);
  const [gameOver, setGameOver] = useState(true);

  const gameArea = useRef<HTMLDivElement>(null);

  const { player, updatePlayerPos, resetPlayer, playerRotate } = usePlayer();
  const { stage, setStage, rowsCleared } = useStage(player, resetPlayer);
  const { score, setScore, rows, setRows, level, setLevel } = useGameStatus(rowsCleared);

  const movePlayer = (dir: number) => {
    if(!isColliding(player, stage, {x: dir, y: 0})) {
      updatePlayerPos({ x: dir/2, y: 0, collided: false });
    }
  };

  const keyUp =({ keyCode }: { keyCode: number, repeat: boolean}): void => {
    if (!gameOver){
    // change dropspeed when down arrow is released
    if(keyCode === 40) {
      setDropTime(DROPSPEED / level + 200)
    }
  }
  };

  const handleStartGame = (): void => {
    // need to focus window with key events on start
    if(gameArea.current) gameArea.current.focus();
    // reset everything
    setStage(createStage());
    setDropTime(DROPSPEED);
    resetPlayer();
    setScore(0);
    setLevel(1);
    setRows(0);
    setGameOver(false);
  }

  const move = ({ keyCode, repeat }: { keyCode: number; repeat: boolean }): void => {
    if (!gameOver) {
      if (keyCode === 37) { // left key
        movePlayer(-1);
      } else if (keyCode === 39) { // right key
        movePlayer(1);
      } else if (keyCode === 40) { // down key
        // Just call once
        if (repeat) return;
        setDropTime(30);
      } else if (keyCode === 38) { // up key
        playerRotate(stage);
      }
    }
  };

  const drop = (): void => {
    // increase level every 10 rows
    if(rows > level * 10) {
      setLevel(prev => prev + 1);
      // incrase gravity
      setDropTime(DROPSPEED / level + 200)
    }


    if(!isColliding(player, stage, {x: 0, y: 1})) {
      updatePlayerPos({ x: 0, y: .5, collided: false})
    } else {
      // game over
      if(player.pos.y < 1) {
        console.log("game over")
        setGameOver(true);
        setDropTime(null);
      }
      updatePlayerPos({x: 0, y:0, collided: true});
    }
    
  }

  useInterval(() => {
    drop();
  }, dropTime)

  return (
    <StyledTetrisWrapper role='button' tabIndex={0} onKeyDown={move} onKeyUp={keyUp} ref={gameArea} >
      <StyledTetris>
        <div className='display'>
          {gameOver ? (
            <>
              <Display gameOver={gameOver} text="Game Over" />
              <StartButton callback={handleStartGame} />
            </>
          ) : (
            <>
              <Display text={`Score: ${score} `} />
              <Display text={`Rows: ${rows}`} />
              <Display text={`Level: ${level}`} />
            </>
          )
          }
        </div>
        <Stage stage={stage} />
      </StyledTetris>
    </StyledTetrisWrapper>
  );
};

export default App;