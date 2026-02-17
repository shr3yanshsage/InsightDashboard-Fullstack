CREATE TABLE IF NOT EXISTS dashboard_records (
    id SERIAL PRIMARY KEY,
    account_number VARCHAR(50),
    age INTEGER,
    company_name VARCHAR(100),
    product_type VARCHAR(100),
    states VARCHAR(10),
    size_of_company VARCHAR(50),
    number_of_api_calls INTEGER
);

-- Insert 500 random records
DO $$
BEGIN
FOR i IN 1..500 LOOP
    INSERT INTO dashboard_records (
        account_number,
        age,
        company_name,
        product_type,
        states,
        size_of_company,
        number_of_api_calls
    ) VALUES (
        'ACC-' || LPAD(i::text, 5, '0'),
        (20 + floor(random() * 45))::int,
        (ARRAY['Acme Tech','Blue Sky','Nimbus Labs','Crestpoint','GreenLeaf','Titan Energy','Zenith Health','Orbit Media','Vantage Logistics','PolarSoft'])[floor(random()*10)+1],
        (ARRAY['SaaS','FinTech','AI/ML','HealthTech','Gaming','IoT','Hardware','Renewable','Content','Logistics'])[floor(random()*10)+1],
        (ARRAY['CA','TX','NY','FL','WA','NV','IL','CO','GA','MA'])[floor(random()*10)+1],
        (ARRAY['Small','Medium','Large'])[floor(random()*3)+1],
        (500 + floor(random() * 50000))::int
    );
END LOOP;
END $$;
