import { BrowserRouter, Routes, Route } from 'react-router-dom';
import TetrisPage from './views/TetrisPage';
import Nav from './components/Nav/Nav';
import ScoresPage from './views/ScoresPage';

function App() {
  return (
  <BrowserRouter>
  <Nav />
      <Routes>
        <Route path="/" element={<TetrisPage />} />
        <Route path="/scores" element={<ScoresPage />} />
      </Routes>
  </BrowserRouter>
  )
}

export default App;