import { Card, CardContent, Typography } from '@mui/material';

const CustomCard = ({ title, content }) => {
  return (
    <Card style={{height: 196}}>
      <CardContent>
        <Typography style={{fontSize: 28, fontWeight: 400}}>{ title }</Typography>
        <Typography style={{fontSize: 72, fontWeight: 700, fontFamily: 'Inter'}}>{ content }</Typography>
      </CardContent>
    </Card>
  );
}

export default CustomCard;