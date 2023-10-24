import styled from 'styled-components';

export const StyledTetrisWrapper = styled.div`
  width: 100%;
  height: 95vh;
  overflow: hidden;
  outline: none;
`;

export const StyledAbout = styled.div`
body {
  font-family: 'Press Start 2P', monospace;
  color: white;
  text-align: center;
  margin: 0;
  padding: 20px;
}

#content {
  font-family: 'Press Start 2P', monospace;
  color: white;
  border: 4px solid #fff;
  margin: 20px auto;
  max-width: 500px;
  padding: 20px;
  background-color: #000;
  border-radius: 15px;
  box-shadow: 0 0 10px rgba(255, 255, 255, 0.5);
}
`

export const StyledScoreboard = styled.div`
body {
  font-family: 'Press Start 2P', monospace;
  color: #fff;
  text-align: center;
  margin: 0;
  padding: 20px;
}

.arcade-table {
  font-family: 'Press Start 2P', monospace;
  border: 4px solid #fff;
  margin: 20px auto;
  max-width: 380px;
  padding: 20px;
  background-color: #000;
  border-radius: 15px;
  box-shadow: 0 0 10px rgba(255, 255, 255, 0.5);
}

table {
  width: 100%;
  border-collapse: collapse;
}

thead {
  font-family: 'Press Start 2P', monospace;
  background-color: #000; /* Red background for the header */
  color: #fff;
}

th, td {
  font-family: 'Press Start 2P', monospace;
  padding: 10px;
  text-align: center;
}

tr:nth-child(even) {
  font-family: 'Press Start 2P', monospace;
  background-color: #444; /* Dark gray background for even rows */
}

tr:nth-child(odd) {
  font-family: 'Press Start 2P', monospace;
  background-color: #333; /* Slightly darker gray background for odd rows */
}
`

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