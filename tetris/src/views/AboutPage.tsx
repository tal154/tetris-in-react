import { StyledAbout } from "../App.styles"

export default function About() {

  return (
    <StyledAbout>
      <div id="content">
        <h1>How to Play</h1>
        <p>Left Arrow: moves the block left<br /><br />Right Arrow: moves the
          block right<br /><br />
          Down Arrow: Accelerates the block's fall<br /><br />
          Up Arrow: Rotate the block <br /><br /> Score as many points as possible
          by clearing horizontal lines of Blocks. <br /><br /> You must rotate,
          move, and drop the falling Tetriminos inside the playing field. <br /><br />
          Lines are cleared when they are filled with Blocks and have no empty
          spaces.</p>
      </div>
    </StyledAbout>
  )
}