import React, { useState } from 'react';
import { Button, Typography } from '@mui/material';
import { DateRangeCalendar } from '@mui/x-date-pickers-pro/DateRangeCalendar';

import './Calendar.css';

const Calendar = () => {
  const [value, setValue] = useState([null, null]);

  return (
    <div >
      <Typography color='text.primary' style={{ fontSize: 28, fontWeight: 400, paddingLeft: 4 }}>Filtros rápidos</Typography>
      <Button variant='outlined' style={{ borderRadius: 100, height: 40 }}>Esta semana</Button>
      <Button variant='outlined' style={{ borderRadius: 100, height: 40 }}>Este mes</Button>
      <Button variant='outlined' style={{ borderRadius: 100, height: 40 }}>Mes anterior</Button>
      <Button variant='outlined' style={{ borderRadius: 100, height: 40 }}>Todo el año</Button>

      <div style={{ paddingTop: 12 }}>
        <div className='calendar-buttons'>
          <Button variant='text'>X</Button>
          <Button variant='text'>Save</Button>
        </div>
        <DateRangeCalendar
          disableAutoMonthSwitching={true}
          calendars={1}
          value={value}
          onChange={setValue}
          sx={{ width: 420, height: 400 }}
        />
        <div className='calendar-buttons calendar-divider'>
          <Button variant='text' style={{ height: 40 }}>Clear</Button>
          <div>
            <Button variant='text' style={{ height: 40 }}>Cancel</Button>
            <Button variant='text' style={{ height: 40 }}>Ok</Button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Calendar;
