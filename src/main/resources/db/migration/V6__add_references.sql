alter table DRIVERRACERESULTS
    add foreign key (DRIVER_ID) references DRIVERS(ID);

alter table DRIVERRACERESULTS
    add foreign key (RACE_ID) references RACES(ID);

