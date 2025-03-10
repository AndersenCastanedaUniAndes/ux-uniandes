import { createTheme } from '@mui/material/styles';

const theme = createTheme({
  typography: {
    fontFamily: 'Roboto, sans-serif',
  },
  shape: {
    borderRadius: 12,
  },
  palette: {
    primary: {
      main: '#65558F',
    },
    text: {
      primary: '#65558F',
    }
    // surface, background, error, etc
  },
  components: {
    MuiButton: {
      styleOverrides: {
        root: {
          textTransform: 'none',
          borderRadius: 100,
        },
      },
    },
    MuiCard: {
      styleOverrides: {
        root: {
          borderRadius: 12,
          backgroundColor: '#FEF7FF',
          border: '1px solid #CAC4D0',
          boxShadow: 'none',
          color: '#65558F',
        },
      },
    },
    MuiDateRangeCalendar: {
      styleOverrides: {
        root: {
          backgroundColor: '#ECE6F0',
          color: '#1D1B20',
        },
      }
    },
    // ... overrides para Drawer, Chip, etc.
  },
});

export default theme;