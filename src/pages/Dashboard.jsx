import StatsPanel from '../components/StatsPanel';
import { Typography } from '@mui/material';

const Dashboard = () => {
  const stats = [
    { title: 'Pausas activas realizadas', content: '104' },
    { title: 'Pausas activas aplazadas', content: '12' },
    { title: 'Pausas activas canceladas', content: '5' },
    { title: 'Porcentaje de cumplimiento', content: '96%' },
  ]

  return (
    <div style={{ paddingTop: 22 }}>
      <Typography color='text.primary' style={{fontSize: 57, fontWeight: 400, paddingLeft: 4}}>Dashboard general</Typography>
      <StatsPanel stats={stats} />
    </div>
  );
}

export default Dashboard;