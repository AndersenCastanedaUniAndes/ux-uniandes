import CustomCard from './CustomCard';
import { Grid } from '@mui/material';

const StatsPanel = ({ stats }) => {
  return (
    <Grid container spacing={2} style={{ marginTop: '76px' }}>
      {stats.map((stat, index) => (
        <Grid item xs={12} sm={6} key={index}>
          <CustomCard title={stat.title} content={stat.content} />
        </Grid>
      ))}
    </Grid>
  );
};

export default StatsPanel;