import CustomCard from './CustomCard';

const StatsPanel = ({ stats }) => {
  return (
    <div style={{display: 'grid', gap: 12, marginTop: 76}}>
      {stats.map((stat, index) => (
        <CustomCard key={index} title={stat.title} content={stat.content} />
      ))}
    </div>
  );
}

export default StatsPanel;