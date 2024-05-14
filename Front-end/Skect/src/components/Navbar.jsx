import React from 'react';
import { useState } from 'react';
import { Skect } from '../assets';
import { navLinks } from '../Constants/Index';
import { Link } from 'react-router-dom';

const Navbar = () => {
  const [toggle, setToggle] = useState(false);

  return (
    <nav className='w-full flex py-6 justify-between items-center navbar'>
      <img src={Skect} alt='skect' className='w-[124px] h-[32px]' />
      <ul className='list-none sm:flex hidden justify-end items-center flex-1'>
        {navLinks.map((nav, index) => (
          <li
            key={nav.id}
            className={`font-poppins font-normal cursor-pointer ${
              index === navLinks.length - 1 ? 'mr-0' : 'mr-10'
            } text-[16px] `}
          >
            <Link to={nav.id === 'home' ? '/' : `/${nav.id}`}>{nav.title}</Link>
          </li>
        ))}
      </ul>
      {/* mobile */}
      <div></div>
    </nav>
  );
}

export default Navbar;
