
import { Typography } from '@mui/material';

import StatsPanel from '../components/StatsPanel';
import Calendar from '../components/Calendar';
import HideText from '../components/HideText';

const Filters = () => {
  const stats = [
    { title: 'Pausas activas realizadas', content: '15' },
    { title: 'Pausas activas aplazadas', content: '2' },
    { title: 'Pausas activas canceladas', content: '3' },
    { title: 'Porcentaje de cumplimiento', content: '85%' },
  ]

  return (
    <div style={{display: 'flex', flexDirection: 'row', gap: 12}}>
      <div>
        <Typography color='text.primary' style={{fontSize: 57, fontWeight: 400, paddingLeft: 4}}>Filtros</Typography>
        <Calendar />
      </div>

      <div style={{paddingTop: 22}}>
        <StatsPanel stats={stats} />
      </div>

      {/* Hiding the MUI X Missing license key text */}
      <HideText searchText='MUI X Missing license key' />
    </div>
  );
}

export default Filters;