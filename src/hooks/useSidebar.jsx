import { useContext } from 'react';
import SidebarContext from '../contexts/SidebarContext';

const useSidebar = () => {
  const context = useContext(SidebarContext);

  if (!context) {
    throw new Error('useSidebar debe usarse dentro de un SidebarProvider');
  }

  return context;
};

export default useSidebar;