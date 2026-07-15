declare module '@apiverve/numberbaseconverter' {
  export interface numberbaseconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface numberbaseconverterResponse {
    status: string;
    error: string | null;
    data: NumberBaseConverterData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface NumberBaseConverterData {
      inputValue:     null | string;
      inputBase:      number | null;
      inputBaseName:  null | string;
      decimalValue:   number | null;
      outputValue:    null | string;
      outputBase:     number | null;
      outputBaseName: null | string;
  }

  export default class numberbaseconverterWrapper {
    constructor(options: numberbaseconverterOptions);

    execute(callback: (error: any, data: numberbaseconverterResponse | null) => void): Promise<numberbaseconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: numberbaseconverterResponse | null) => void): Promise<numberbaseconverterResponse>;
    execute(query?: Record<string, any>): Promise<numberbaseconverterResponse>;
  }
}
