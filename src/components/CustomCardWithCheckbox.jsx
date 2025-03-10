import { Card, CardContent, Checkbox, Typography } from '@mui/material';

const CustomCardWithCheckbox = ({ title, content }) => {
  return (
    <Card style={{height: 80}}>
      <CardContent>
        <div style={{display: 'flex', flexDirection: 'row', justifyContent: 'space-between'}}>
            <div>
                <Typography style={{fontSize: 16, fontWeight: 500, color: '#1D1B20'}}>{ title }</Typography>
                <Typography style={{fontSize: 14, fontWeight: 400, color: '#1D1B20'}}>{ content }</Typography>
            </div>
            <Checkbox />
        </div>
      </CardContent>
    </Card>
  );
}

export default CustomCardWithCheckbox;