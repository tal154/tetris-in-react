import { BrowserRouter, Routes, Route } from 'react-router-dom';
import TetrisPage from './views/TetrisPage';
import Nav from './components/Nav/Nav';
import ScoresPage from './views/ScoresPage';
import AboutPage from './views/AboutPage';

function App() {
  return (
  <BrowserRouter>
  <Nav />
      <Routes>
        <Route path="/" element={<TetrisPage />} />
        <Route path="/scores" element={<ScoresPage />} />
        <Route path="/about" element={<AboutPage />} />
      </Routes>
  </BrowserRouter>
  )
}

export default App;