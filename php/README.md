# Number Base Converter API - PHP Package

Number Base Converter converts numbers between any base from 2 to 36, including binary, octal, decimal, and hexadecimal. Pass a value with optional source and target bases to receive the converted string, base names, and exact decimal values.

## Installation

Install via Composer:

```bash
composer require apiverve/numberbaseconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Numberbaseconverter\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'value' => '255',
    'from' => 10,
    'to' => 10
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Numberbaseconverter\Client;
use APIVerve\Numberbaseconverter\Exceptions\APIException;
use APIVerve\Numberbaseconverter\Exceptions\ValidationException;

try {
    $response = $client->execute(['value' => '255', 'from' => 10, 'to' => 10]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/numberbaseconverter?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/numberbaseconverter?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/numberbaseconverter?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
