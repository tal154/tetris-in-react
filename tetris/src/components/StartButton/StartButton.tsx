import { StyledStartButton } from "./StartButton.styles";

interface Props {
    callback: () => void;
}

function StartButton({ callback }: Props) { 
    return <StyledStartButton onClick={callback}>Start</StyledStartButton>
}

export default StartButton;