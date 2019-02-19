import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => (
  <div>
      <nav>
        <ul className="our_links">
          <li ><Link to='/home'>Home</Link></li>
          <li ><Link to='/create'>Create</Link></li>
        </ul>
      </nav>
  </div>

)

export default Header;
