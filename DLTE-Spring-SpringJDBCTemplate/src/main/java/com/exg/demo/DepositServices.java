package com.exg.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Service
public class DepositServices {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FixedDeposit> fixedDepositList( int amount)

    {
        return jdbcTemplate.query("Select * from fixeddep where deposit_amount=?",new Object[]{amount},new DepositMapper());
    }



    class DepositMapper implements RowMapper<FixedDeposit> {
        @Override
        public FixedDeposit mapRow(ResultSet rs, int rowNum) throws SQLException {
            FixedDeposit deposit = new FixedDeposit();
            deposit.setDeposit_id(rs.getInt("deposit_id"));
            deposit.setDeposit_amount(rs.getInt("deposit_amount"));
            deposit.setDeposit_tenure(rs.getInt("deposit_tenure"));
            deposit.setMature_date(rs.getDate("deposit_date"));
            deposit.setInt_rate(rs.getInt("int_rate"));
            deposit.setMature_date(rs.getDate("Mature_date"));
            deposit.setMode_if_divi(rs.getString("Mode_of_divi"));

            return deposit;
        }
    }
}



