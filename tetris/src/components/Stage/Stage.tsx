import Cell from '../Cell/Cell';
import { StyledStage } from './Stage.styles';
import { TETROMINOS } from '../../setup';

export type STAGECELL = [keyof typeof TETROMINOS, string];
export type STAGE = STAGECELL[][];

interface Props {
    stage: STAGE;
}

function Stage({ stage }: Props) {
    return (
        <StyledStage>
            {stage.map(row => row.map((cell, x) => <Cell key={x} type={cell[0]} />))}
        </StyledStage>
    )        
} 

export default Stage;