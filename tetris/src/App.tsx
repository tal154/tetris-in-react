import { BrowserRouter, Routes, Route } from 'react-router-dom';
import TetrisPage from './views/TetrisPage';

function App() {
  return (
  <BrowserRouter>
      <Routes>
        <Route path="/" element={<TetrisPage />} />

      </Routes>
  </BrowserRouter>
  )
}

export default App;