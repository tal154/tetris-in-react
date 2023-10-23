import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import "bootstrap/dist/css/bootstrap.css"
import './App.styles'
import { createGlobalStyle } from 'styled-components'

const GlobalStyles = createGlobalStyle`
  body {
    margin: 0;
    padding: 0;
    height: 100vh;
    background-image: url("https://i.ibb.co/YTN069M/tetris.jpg");
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    overflow: hidden;
  }
`;

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
      <GlobalStyles />
      <App />
  </React.StrictMode>,
)
