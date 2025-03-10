import { Button, Typography } from '@mui/material';
import CustomCardWithCheckbox from '../components/CustomCardWithCheckbox';
import { useState } from 'react';

const Notifications = () => {
  const [fullWeek, setFullWeek] = useState(true);

  const dates = [
    {
      title: 'Lunes',
      content: [
        { Fecha: '10-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '10-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '10-03-2025', Hora: '11:30 - 11:45' },
        { Fecha: '10-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '10-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '10-03-2025', Hora: '11:30 - 11:45' },
        { Fecha: '10-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '10-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '10-03-2025', Hora: '11:30 - 11:45' },
        { Fecha: '10-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '10-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '10-03-2025', Hora: '11:30 - 11:45' },
      ],
    },
    {
      title: 'Martes',
      content: [
        { Fecha: '11-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '11-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '11-03-2025', Hora: '11:30 - 11:45' },
      ],
    },
    {
      title: 'Miércoles',
      content: [
        { Fecha: '12-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '12-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '12-03-2025', Hora: '11:30 - 11:45' },
        { Fecha: '12-03-2025', Hora: '9:30 - 9:45' },
      ],
    },
    {
      title: 'Jueves',
      content: [
        { Fecha: '13-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '13-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '13-03-2025', Hora: '11:30 - 11:45' },
        { Fecha: '13-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '13-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '13-03-2025', Hora: '11:30 - 11:45' },
      ],
    },
    {
      title: 'Viernes',
      content: [
        { Fecha: '14-03-2025', Hora: '9:30 - 9:45' },
        { Fecha: '14-03-2025', Hora: '10:30 - 10:45' },
        { Fecha: '14-03-2025', Hora: '11:30 - 11:45' },
      ],
    },
  ];

  return (
    <div>
      <Typography color='text.primary' style={{fontSize: 57, fontWeight: 400, paddingLeft: 4}}>Notificaciones</Typography>
      <br/>

      <Typography color='text.primary' style={{fontSize: 28, fontWeight: 400, paddingLeft: 4}}>
        En base a tu Google Calendar, estos son los espacios que hemos <br/> encontrado para tus pausas activas, marca los que desees usar.
      </Typography>

      <br/>

      <div style={{display: 'flex', flexDirection: 'row', alignItems: 'center', gap: 18}}>
        <Typography color='text.primary' style={{fontSize: 28, fontWeight: 400, paddingLeft: 4}}>Ver por:</Typography>

        <Button variant={fullWeek ? 'contained' : 'outlined'} style={{ borderRadius: 100, height: 40 }} onClick={() => setFullWeek(true)}>Esta semana</Button>
        <Button variant={!fullWeek ? 'contained' : 'outlined'} style={{ borderRadius: 100, height: 40 }} onClick={() => setFullWeek(false)}>Hoy</Button>
      </div>

      <br/>
      <br/>
      <br/>

      <div
        style={{
          display: 'flex',
          flexDirection: 'row',
          flexWrap: 'wrap',
          gap: 12,
        }}
      >
        {fullWeek && dates.map((date, index) => (
          <div
            className='scrollbar'
            style={{
              minWidth: 265,
              maxHeight: '320px',
              overflowY: 'auto',
              padding: '8px',
              scrollbarColor: '#FFFFFF #D9D9D9',
            }}
            key={index}
          >
            <Typography color='text.primary' style={{ fontSize: 32, fontWeight: 400 }}>{date.title}</Typography>
            {date.content.map((item, index) => (
              <CustomCardWithCheckbox key={index} title={item.Fecha} content={item.Hora} />
            ))}
          </div>
        ))}
        {!fullWeek && dates.slice(2, 3).map((date, index) => (
          <div
            className='scrollbar'
            style={{
              minWidth: 265,
              maxHeight: '320px',
              overflowY: 'auto',
              padding: '8px',
              scrollbarColor: '#FFFFFF #D9D9D9',
            }}
            key={index}
          >
            <Typography color='text.primary' style={{ fontSize: 32, fontWeight: 400 }}>{date.title}</Typography>
            {date.content.map((item, index) => (
              <CustomCardWithCheckbox key={index} title={item.Fecha} content={item.Hora} />
            ))}
          </div>
        ))}
      </div>
    </div>
  );
}

export default Notifications;