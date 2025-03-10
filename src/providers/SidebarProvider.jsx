import { useState } from 'react';
import SidebarContext from '../contexts/SidebarContext';

export const SidebarProvider = ({ children }) => {
  const [activeItem, setActiveItem] = useState('dashboard');

  return (
    <SidebarContext.Provider value={{ activeItem, setActiveItem }}>
      {children}
    </SidebarContext.Provider>
  );
};