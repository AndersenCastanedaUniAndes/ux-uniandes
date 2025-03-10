const SidebarItem = ({ icon, name, state, onClick }) => {
  return (
    <div className={`sidebar-item ${state}`} onClick={onClick}>
      <p className='material-icons'>{icon}</p>
      <p>{name}</p>
    </div>
  );
}

export default SidebarItem;