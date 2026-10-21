# Number Base Converter API - Ruby Gem

Number Base Converter converts numbers between any base from 2 to 36, including binary, octal, decimal, and hexadecimal. Pass a value with optional source and target bases to receive the converted string, base names, and exact decimal values.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_numberbaseconverter'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_numberbaseconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_numberbaseconverter'

# Initialize the client
client = APIVerve::Numberbaseconverter::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  value: "255",
  from: 10,
  to: 10
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ value: "255", from: 10, to: 10 })
  puts response["data"]
rescue APIVerve::Numberbaseconverter::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Numberbaseconverter::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Numberbaseconverter::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "input_value": "FF",
    "input_base": 16,
    "input_base_name": "hexadecimal",
    "decimal_value": 255,
    "decimal_value_exact": "255",
    "output_value": "255",
    "output_base": 10,
    "output_base_name": "decimal"
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/numberbaseconverter?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/numberbaseconverter?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/numberbaseconverter?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
