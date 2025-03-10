import Sidebar from './components/Sidebar';
import useSidebar from './hooks/useSidebar';
import Dashboard from './pages/Dashboard';
import Filters from './pages/Filters';
import Notifications from './pages/Notifications';

const Layout = () => {
  const { activeItem } = useSidebar();

  return (
    <div style={{ display: 'flex', height: '100vh', gap: '1rem' }}>
      <div style={{ minWidth: 350 }}>
        <Sidebar />
      </div>
      <div>
        {activeItem === 'dashboard' && <Dashboard />}
        {activeItem === 'filters' && <Filters />}
        {activeItem === 'notifications' && <Notifications />}
      </div>
    </div>
  );
};

export default Layout;