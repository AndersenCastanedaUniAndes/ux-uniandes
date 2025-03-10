import './App.css';
import { SidebarProvider } from './providers/SidebarProvider';
import Layout from './Layout';

const App = () => {
  return (
    <div>
      <SidebarProvider>
        <Layout />
      </SidebarProvider>
    </div>
  );
}

export default App;