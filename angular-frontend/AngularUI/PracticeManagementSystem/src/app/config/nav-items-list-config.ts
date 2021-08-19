export const NAV_ITEMS_LIST = [
    {
        permitTo: ['nurse','physician'], icon: 'inbox', navItem: 'Inbox', route: 'inbox/sharedinbox'
    },
    {
        permitTo: ['physician'], icon: 'notes', navItem: 'Visit Form', route: 'visit/visit_form'
    },
    {
        permitTo: ['nurse'], icon: 'notes', navItem: 'Vital Signs', route: 'visit/vital_form'
    },
    
    // {
    //     permitTo: ['physician'], icon: 'calendar_today', navItem: 'Calendar', route: 'schedule/calendarapi'
    // },
  
   
    {
        permitTo: ['patient'], icon: 'details', navItem: 'Patient Details', route: 'usermanagement/patientDetails'
    },
    {
        permitTo: ['admin'], icon: 'people', navItem: 'Patient users', route: 'admin/userList'
    },
    {
        permitTo: ['admin'], icon: 'supervised_user_circle', navItem: 'Hospital Users', route: 'admin/hospitalUserList'
    },
    {
        permitTo: ['patient'], icon: 'schedule', navItem: 'Book Appointment', route: 'visit/appointmentForm'
    },
    
    {
        permitTo: ['physician'], icon: 'event_note', navItem: 'Appointment Details', route: 'schedule/appointmentDetails'
    }
];
