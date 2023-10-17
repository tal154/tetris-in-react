import styled from 'styled-components';

export const StyledTetrisWrapper = styled.div`
  width: 100%;
  height: 100vh;
  overflow: hidden;
  outline: none;
`;

export const StyledTetris = styled.div`
  font-family: "Press Start 2P", monospace;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 40px;
  margin: 0 auto;

  .display {
    font-family: "Press Start 2P", monospace;
    display: flex;
    justify-content: space-between;
    width: 380px;
  }
`;