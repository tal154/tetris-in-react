import { StyledDisplay } from "./Display.styles";

interface Props {
    gameOver?: boolean;
    text: String;
}

function Display({ gameOver, text }: Props) {
    return <StyledDisplay gameOver={gameOver}>{text}</StyledDisplay>
}

export default Display;