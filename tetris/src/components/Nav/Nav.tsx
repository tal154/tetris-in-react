import { NavLink } from "react-router-dom";
import { StyledNav } from "../../App.styles";
import { Nav, Navbar } from 'react-bootstrap';


export default function Header() {
    return (
        <StyledNav>
            <Navbar expand="lg">
                <div className='container-fluid'>
                    <NavLink className='navbar-brand' to='/'>
                        Play
                    </NavLink>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse>
                        <Nav>
                            <ul className='navbar-nav'>
                                <li className='nav-item'>
                                    <NavLink className='nav-link' to='/scores'>
                                        Score
                                    </NavLink>
                                </li>
                            </ul>
                        </Nav>
                    </Navbar.Collapse>
                </div>
            </Navbar>
        </StyledNav>
    )
}

