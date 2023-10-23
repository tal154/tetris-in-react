import { useEffect, useState } from "react";
import { StyledScoreboard } from "../App.styles";
// import toast from "react-hot-toast";

type scoresProps = {
  userId: number,
  username: String,
  score: number;
}

export default function Score() {

  const [scores, setScores] = useState<scoresProps[]>([]);

  useEffect(() => {
    fetch('http://localhost:8080/scores')
      .then(res => res.json())
      .then(data => setScores(data));
  }, []);

  return (
    <StyledScoreboard>
      <body>
        <div className="arcade-table">
          <h1>Top Ten Scores</h1>
          <table className="table table-striped">
            <thead>
              <tr>
                <th>Name</th>
                <th>Score</th>
              </tr>
            </thead>
            <tbody>
              {scores.map(score => (
                <tr key={score.userId}>
                  <td>{score.username}</td>
                  <td>{score.score}</td>
                </tr>
              ))}
            </tbody>
          </table></div>
      </body>
    </StyledScoreboard>
  );
}

