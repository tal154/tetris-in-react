import styled from 'styled-components';

export const StyledTetrisWrapper = styled.div`
  width: 100%;
  height: 95vh;
  overflow: hidden;
  outline: none;
`;

export const StyledNav = styled.div`
  width: 100%;
  height: 50px;
  background: cyan;
  border-bottom: 1px solid black;
  display: flex;
  align-items: center;
  font-family: "Press Start 2P", monospace;
  justify-content: space-between;
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