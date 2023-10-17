import React from 'react';
import { StyledCell } from './Cell.styles';
import { TETROMINOS } from '../../setup';

interface Props {
    type: keyof typeof TETROMINOS;
}

function Cell({ type }: Props) {
    return <StyledCell type={type} color={TETROMINOS[type].color} />
} 

// memo on rerenders cells that change
export default React.memo(Cell);