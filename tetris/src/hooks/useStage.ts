import { useState, useEffect } from 'react';
import { createStage } from '../gameHelpers';

// types
import { PLAYER } from './usePlayer';

export type STAGECELL = [string | number, string];
export type STAGE = STAGECELL[][];

export const useStage = (player: PLAYER, resetPlayer: () => void) => {
  const [stage, setStage] = useState(createStage());
  const [rowsCleared, setRowsCleared] = useState(0);

  useEffect(() => {
    if (!player.pos) return;

    setRowsCleared(0);

    const sweepRows = (newStage: STAGE): STAGE => {
      return newStage.reduce((accumulator, row) => {
        // don't find a 0 it means that the row is full and should be cleared
        if (row.findIndex(cell => cell[0] === 0) === -1) {
          setRowsCleared(prev => prev + 1);
          // create an empty row at the beginning of the array to push the tetrominos down
          // instead of returning the cleared row
          accumulator.unshift(new Array(newStage[0].length).fill([0, 'clear']) as STAGECELL[]);
          return accumulator;
        }

        accumulator.push(row);
        return accumulator;
      }, [] as STAGE);
    };

    const updateStage = (prevStage: STAGE): STAGE => {
      // flush the stage
      // if "clear" but don't have a 0 it means that it's the players move and should be cleared
      const newStage = prevStage.map(
        row => row.map(cell => (cell[1] === 'clear' ? [0, 'clear'] : cell)) as STAGECELL[]
      );

      // draw the tetromino
      player.tetromino.forEach((row, y) => {
        row.forEach((value, x) => {
          if (value !== 0) {
            if(newStage[y + player.pos.y]) {
              newStage[y + player.pos.y][x + player.pos.x] = [value, `${player.collided ? 'merged' : 'clear'}`];
            }            
          }
        });
      });

      if (player.collided) {
        resetPlayer();
        return sweepRows(newStage);
      }

      return newStage;
    };

    setStage(prev => updateStage(prev))
  }, [player.collided, player.pos?.x, player.pos?.y, player.tetromino]);

  return { stage, setStage, rowsCleared };
};