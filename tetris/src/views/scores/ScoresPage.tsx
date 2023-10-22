import { useEffect, useState } from "react";
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

    const fetchScore = async () => {
        const response = await fetch("http://localhost:8080/scores");
        const data = await response.json();
        setScores(data);
    }

    // useEffect(() => {
    //     const api = async () => {
    //       const data = await fetch("https://randomuser.me/api", {
    //         method: "GET"
    //       });
    //       const jsonData = await data.json();
    //       setScores(jsonData.results);
    //     };
    
    //     api();
    //   }, []);


    return (
        <>
            <h1>Scores</h1>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Score</th>
                    </tr>
                </thead>
                <tbody>
                    {scores.map(post => (
                        <tr key={post.userId}>
                            <td>{post.username}</td>
                            <td>{post.score}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
        
    );
}

