import useSidebar from '../hooks/useSidebar';
import SidebarItem from './SidebarItem';
import './Sidebar.css';

const Sidebar = () => {
  const { activeItem: selectedItem, setActiveItem } = useSidebar();

  return (
    <div
      style={{
        backgroundColor: '#F7F2FA',
        borderRadius: '0px 52px 52px 0px',
        display: 'flex',
        flexDirection: 'column',
        height: '100%',
      }}
    >
      <div style={{padding: '43px 12px'}}>
        <h2>StepOut</h2>
        <nav>
          <SidebarItem
            icon='menu'
            name='Dashboard general'
            state={`${selectedItem === 'dashboard' ? 'sidebar-item-selected' : ''}`}
            onClick={() => setActiveItem('dashboard')}
          />
          <SidebarItem
            icon='search'
            name='Filtros'
            state={`${selectedItem === 'filters' ? 'sidebar-item-selected' : ''}`}
            onClick={() => setActiveItem('filters')}
          />
          <SidebarItem
            icon='schedule'
            name='Notificaciones'
            state={`${selectedItem === 'notifications' ? 'sidebar-item-selected' : ''}`}
            onClick={() => setActiveItem('notifications')}
          />
        </nav>
      </div>
    </div>
  );
};

export default Sidebar;